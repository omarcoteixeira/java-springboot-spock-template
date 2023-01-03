package br.com.omarcoteixeira.data.model.user;

import br.com.omarcoteixeira.data.model.post.Post;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {
  String id;
  String name;
  List<Post> posts;
}
