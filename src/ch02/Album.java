package ch02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * {
  	 "userId": 1,
  	 "id": 1,
   	 "title": "quidem molestiae enim"
	}
 */

// DTO -- Data Transfer Object
// private --> Gson lib --> 변수에 접근해서 json 값을 넣어준다.
// Setter 필요하다

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Album {

	private int userId;
	private int id;
	private String title;
	
}
