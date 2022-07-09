package game.guidebook.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class RegisterDto implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String name;
	private String nickname;
	private String mobile;
//	private String email;
	private String password;
	private String ip;
	private String validCode;

}
