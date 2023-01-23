package br.com.omarcoteixeira.data.model.user;

import br.com.omarcoteixeira.data.model.post.Post;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
  String id;
  String name;
  List<Post> posts;
}
