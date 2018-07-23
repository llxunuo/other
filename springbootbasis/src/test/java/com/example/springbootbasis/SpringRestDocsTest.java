package com.example.springbootbasis;

import com.example.springbootbasis.component.CallPrintMessage;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(CallPrintMessage.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
class SpringRestDocsTest {

}
