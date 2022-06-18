//
//import ch.ethz.ssh2.Connection;
//import ch.ethz.ssh2.Session;
//import ch.ethz.ssh2.StreamGobbler;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.feign.FeignApplication;
//import com.md.mybatisplus.t.service.LocalTestService;
//import com.md.mybatisplus.t.service.OrderService;
//import org.apache.commons.lang3.StringUtils;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = FeignApplication.class)
//@WebAppConfiguration
//
//public class Test {
//
//    @Autowired
//    OrderService orderService;
//
//    @Autowired
//    LocalTestService localTestService;
//
//
//
//  @org.junit.Test
//    public  void getLearn()  {
//
//
//
//      //////////////////////////////////////////////////////
//
//     // orderService.orderAndDetails();
//
//
////      Map<String, Object> map=new HashMap<>();
////      map.put("name","sv");
////      //批量删除 多条件
////      QueryWrapper wrapper = new QueryWrapper();
////      // wrapper.equals(map);
////
////       wrapper.eq("id",map.get(1135));
////       wrapper.eq("name",map.get("sv"));.
////      localTestService.remove(wrapper);
//    }}
//
//
//
//
//
///**
// * //      try {
// * //          conn = new Connection("192.168.2.136");
// * //          conn.connect();//连接
// * //          flg=conn.authenticateWithPassword("phil", "ph");//认证
// * //            System.out.println(flg+"当地的");
// * //      } catch (IOException e) {
// * //
// * //          e.printStackTrace();
// * //      }
// **/