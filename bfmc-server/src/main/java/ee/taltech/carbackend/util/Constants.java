package ee.taltech.carbackend.util;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

  public static final String TEMP_CREATED_BY = "e8d806d7-ebf8-4ccb-b5a5-48383c530a8e";
  public static final String TEMP_MODIFIED_BY = "e8d806d7-ebf8-4ccb-b5a5-48383c530a8e";

  public static UUID SESSION_UUID;
}