package restful.spring.boot.restful.spring.boot.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restful.spring.boot.restful.spring.boot.Model.CopyUser;
import restful.spring.boot.restful.spring.boot.Model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/getUsuario")
	public User GetUsuario() {
		User user = new User();
		user.setId(1);
		user.setNombre("Kevin");
		user.setApellido("Matos");
		user.setEmail("victorkevin.ms@gmail.com");
		return user;
	}

	@GetMapping("/getUsuario2")
	public ResponseEntity<User> GetUsuario2() {
		User user = new User();
		user.setId(1);
		user.setNombre("Kevin");
		user.setApellido("Matos");
		user.setEmail("victorkevin.ms@gmail.com");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/getlstUsuario")
	public List<User> GetlstUsuario() {
		List<User> lst = new ArrayList<User>();

		User user1 = new User();
		user1.setId(1);
		user1.setNombre("Kevin");
		user1.setApellido("Matos");
		user1.setEmail("victorkevin.ms@gmail.com");

		User user2 = new User();
		user2.setId(2);
		user2.setNombre("Marco");
		user2.setApellido("Matos");
		user2.setEmail("marcoant.ms@gmail.com");

		User user3 = new User();
		user3.setId(3);
		user3.setNombre("Walter");
		user3.setApellido("Matos");
		user3.setEmail("walterhg.ms@gmail.com");

		User user4 = new User();
		user4.setId(4);
		user4.setNombre("Jesus");
		user4.setApellido("Matos");
		user4.setEmail("jesusmar.ms@gmail.com");

		lst.add(user1);
		lst.add(user2);
		lst.add(user3);
		lst.add(user4);

		return lst;
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, })
	public List<User> GetlstUsuario2() {
		List<User> lst = new ArrayList<User>();

		User user1 = new User();
		user1.setId(1);
		user1.setNombre("Kevin");
		user1.setApellido("Matos");
		user1.setEmail("victorkevin.ms@gmail.com");

		User user2 = new User();
		user2.setId(2);
		user2.setNombre("Marco");
		user2.setApellido("Matos");
		user2.setEmail("marcoant.ms@gmail.com");

		User user3 = new User();
		user3.setId(3);
		user3.setNombre("Walter");
		user3.setApellido("Matos");
		user3.setEmail("walterhg.ms@gmail.com");

		User user4 = new User();
		user4.setId(4);
		user4.setNombre("Jesus");
		user4.setApellido("Matos");
		user4.setEmail("jesusmar.ms@gmail.com");

		lst.add(user1);
		lst.add(user2);
		lst.add(user3);
		lst.add(user4);

		return lst;
	}

	@GetMapping
	public String GetUser() {
		return "Usuario Obtenido";
	}

	/*
	@PostMapping
	public String CreateUser() {
		return "Usuario Creado";
	}
	*/

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> CreateUser2(@Valid @RequestBody CopyUser copyUser) {
		User user = new User();
		user.setNombre(copyUser.getNombre());
		user.setApellido(copyUser.getApellido());
		user.setEmail(copyUser.getEmail());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping
	public String UpdateUser() {
		return "Usuario Actualizado";
	}

	@DeleteMapping
	public String DeleteUser() {
		return "Usuario Eliminado";
	}
}
