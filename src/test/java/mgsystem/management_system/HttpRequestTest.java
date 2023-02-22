package mgsystem.management_system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

public class HttpRequestTest {
    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void shouldReturn() throws Exception{
        assertThat(this.template.getForObject("http://localhost:" + port + "/",String.class));
    }
}
