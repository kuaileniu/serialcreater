package cn.zhsit.controllers;

import cn.zhsit.Application;
import cn.zhsit.daos.ZyZytybhbMapperTest;
import cn.zhsit.daos.ZyZzidzdbhbMapperTest;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class SerialControllerTest {
    @Rule
    public ContiPerfRule ie = new ContiPerfRule();
    private MockMvc mockMvc;
    @Autowired
    private SerialController serialController;

    @Before
    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(new SerialController()).build();
        mockMvc = MockMvcBuilders.standaloneSetup(serialController).build();
    }


    @Test
    @PerfTest(invocations = 10000, threads = 20)
    public void testGive() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/serial/give").param("orgCode", "ct").param("productCode", "jy").param("count", "2").accept(MediaType.TEXT_HTML_VALUE)).andDo(new ResultHandler() {
            @Override
            public void handle(MvcResult result) throws Exception {
//                System.out.println("返回的数据："+result.getResponse().getContentAsString());
            }
        }).andExpect(status().isOk());
//        .andExpect(content().string(equalTo("{\"code\":\"ok\",\"msg\":\"80000000caituan23\"}")));
    }

/**

 @Test public void getHello() throws Exception {
 mockMvc.perform(MockMvcRequestBuilders.get("/hello1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
 .andExpect(content().string(equalTo("Hello World")));
 }

 @Test public void getHello2() throws Exception {
 mockMvc.perform(MockMvcRequestBuilders.get("/hello2").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
 .andExpect(content().string(equalTo("[\"A\",\"B\",\"C\"]")));
 }

 **/


}
