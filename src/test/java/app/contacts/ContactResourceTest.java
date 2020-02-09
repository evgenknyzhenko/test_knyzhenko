package app.contacts;

import app.BaseTest;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class ContactResourceTest extends BaseTest {

  /**
   * @Test Test for {@link app.contacts.ContactResource#findContacts(java.lang.String, long, long)}
   */
  @Test
  public void testFindContacts() throws Exception {

    mockMvc
        .perform(MockMvcRequestBuilders.get("/hello/contacts").param("nameFilter", "^A.*$"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(7)))
        .andReturn();

    mockMvc
        .perform(MockMvcRequestBuilders.get("/hello/contacts").param("nameFilter", "^.*[t].*$"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(6)))
        .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", Matchers.is("Jenifer")))
        .andReturn();

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/hello/contacts")
                .param("nameFilter", "^J.*$")
                .param("page", "0")
                .param("size", "5"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(5)))
        .andReturn();

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/hello/contacts")
                .param("nameFilter", "^J.*$")
                .param("page", "1")
                .param("size", "5"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
        .andReturn();
  }
}
