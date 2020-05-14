package com.lc.consultant.jdbc;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class VoucherDaoTest {

    private static VoucherDAO voucherDAO;

    private static DataSource dataSource;

    @BeforeClass
    public static void setUp(){
        dataSource = DataSourceBuilder
                .create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://172.17.162.1:3306/test?serverTimezone=GMT%2B8&useSSL=false")
                .username("root")
                .password("Dev@2019")
                .build();

        voucherDAO = new VoucherDAO();
        voucherDAO.setDataSource(dataSource);
    }


    @Test
    public void whenInjectInMemoryDataSource_thenReturnCorrectVoucherCount() {
//        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
//                .addScript("classpath:jdbc/schema.sql")
//                .addScript("classpath:jdbc/test-data.sql")
//                .build();

//        DataSource dataSource = DataSourceBuilder
//                .create()
//                .driverClassName("com.mysql.jdbc.Driver")
//                .url("jdbc:mysql://192.168.134.97:3306/test?serverTimezone=GMT%2B8&useSSL=false")
//                .username("root")
//                .password("Dev@2019")
//                .build();
//
//        VoucherDAO voucherDAO = new VoucherDAO();
//        voucherDAO.setDataSource(dataSource);

        Assert.assertEquals(2, voucherDAO.getCountOfVouchers());
    }

    @Test
    public void shouldReturnCorrectVoucherList(){
        Assert.assertEquals(2, voucherDAO.getVouchers().size());
    }

    @Test
    public void whenGetVoucherDetails() {
        List voucherDetails = voucherDAO.getVoucherDetails();

        System.out.println("voucherDetails = " + voucherDetails);

        Assert.assertEquals(5, voucherDetails.size());
    }

    @Test
    public void whenGetVoucherDetailsWithProjectAccount() {
        List<Map<String, Object>> details = voucherDAO.getVoucherDetails();

        System.out.println("voucherDetails = " + details);

        Assert.assertEquals(5, details.size());

//        Map collect = details.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt()));
//        Map simpleGroupby = details.stream().collect(
//                groupingBy(map -> map.get("voucher_no") ) ));

        Map simpleGroupby = details.stream()
                .map(map -> new AbstractMap.SimpleEntry<>(map.get("vcoucher_code"), map.get("credit_amount")))
                .collect(Collectors.groupingBy(Map.Entry::getKey));

        System.out.println("collect = " + simpleGroupby);

        Assert.assertEquals(2, simpleGroupby.size());
        

    }

    @Test
    public void whenGetVoucherDetailsGroupData() {

        List voucherDetailsGroupData = voucherDAO.getVoucherDetailsGroupData();

        System.out.println("voucherDetailsGroupData = " + voucherDetailsGroupData);
    }

    @Test
    public void whenGetGroupData_thenMergeIntoRawDataAsTheWholeList() {
        List voucherDetailsGroupData = voucherDAO.getVoucherDetailsGroupData();

        List<VoucherDimension> list = voucherDAO.getVoucherDetailsWithProjectAccountAsMapper();

        List collect = (List) Stream.of(voucherDetailsGroupData, list)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());



        System.out.println("collect = " + collect.size());


        collect.forEach(e -> System.out.println("element = " + e));

        //or use commons collections utility
        Collection<VoucherDimension> unionList = CollectionUtils.union(voucherDetailsGroupData, list);
//        Collections.sort(unionList, );

        //sorting by multiple columns
//        Collections.sort(unionList, new Comparator<VoucherDimension>() {
//            public int compare(VoucherDimension o1, VoucherDimension o2) {
//                return 0;
//            }
//        });
        unionList.forEach(e -> System.out.println("e = " + e));

        List<VoucherDimension> sortedList = unionList.stream()
                .sorted(Comparator.comparing(VoucherDimension::getVoucherNo)
                                .thenComparing(VoucherDimension::getSortByGroup)
                                .thenComparing(VoucherDimension::getSeq)
                        )
                .collect(Collectors.toList());

//        System.out.println("sortedList = " + sortedList);
        sortedList.forEach(e -> System.out.println("element = " + e));
    }

    @Test
    public void whenGetVoucherDetailsWithProjectAccountAsMapper_thenGroupingBy() {

        List<VoucherDimension> list = voucherDAO.getVoucherDetailsWithProjectAccountAsMapper();

        System.out.println("list = " + list);

        Assert.assertEquals(8, list.size());

        Map listByVoucher = list.stream()
                .collect(Collectors.groupingBy(VoucherDimension::getVoucherNo, Collectors.groupingBy(VoucherDimension::getSeq, Collectors.summingInt(VoucherDimension::getDebtAmount)))
                );

        System.out.println("listByVoucher = " + listByVoucher);

        List filteredList = list.stream()
                .map(VoucherDimension::getVoucherDetail)
                .collect(Collectors.toList());

        System.out.println("filteredList = " + filteredList);

//        Map<String, Collection<List<Product>>> m=products.stream().collect(
//                Collectors.groupingBy(Product::getUpc, Collectors.collectingAndThen(
//                        Collectors.groupingBy(Product::getChannelIdentifier), Map::values)));

//        Map groupbyList = list.stream()
//                .map(VoucherDimension::getVoucherDetail)
//                .distinct()
//                .collect(Collectors.groupingBy(VoucherDetail::getVoucherNo));

        Map groupByVoucherSeq = list.stream()
                .map(VoucherDimension::getVoucherDetail)
//                .peek(System.out::println)
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.groupingBy(VoucherDetail::getVoucherNo, Collectors.collectingAndThen(
                        Collectors.groupingBy(VoucherDetail::getSeq), Map::values
                )));

        System.out.println("groupByVoucherSeq = " + groupByVoucherSeq);

//        Assert.assertEquals(5, groupByVoucherSeq.size());

//        System.out.println("groupbyList = " + groupbyList);
//        System.out.println("groupbyList = " + groupbyList.keySet());
//
//        groupbyList.forEach(g -> System.out.println("g = " + g));

    }
}