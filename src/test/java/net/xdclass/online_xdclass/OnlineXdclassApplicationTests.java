package net.xdclass.online_xdclass;

import io.jsonwebtoken.Claims;
import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class OnlineXdclassApplicationTests {

	@Test
	public void testGenJwt() {

		User user = new User();
		user.setId(101);
		user.setName("Robot A");
		user.setHeadshot("png");

		String token = JwtUtils.generateToken(user);
		System.out.println(token);

		Claims claims = JwtUtils.verifyToken(token);
		System.out.println(claims.get("name"));
	}

}
