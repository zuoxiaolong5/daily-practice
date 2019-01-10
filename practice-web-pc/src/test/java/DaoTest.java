import com.daily.practice.dao.order.OrderInfoDAO;
import com.daily.practice.domain.d.o.OrderInfoDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class DaoTest {

    @Resource
    private OrderInfoDAO orderInfoDAO;

    @Test
    public void test() {

        OrderInfoDO orderInfoDO = orderInfoDAO.selectById(1L);
        System.out.println(orderInfoDO.getUserName());
    }
}
