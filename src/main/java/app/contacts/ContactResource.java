package app.contacts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactResource {

    private final ContactService contactService;

    public ContactResource(final ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(path = "/hello/contacts", method = RequestMethod.GET)
    public List<Contact> findContacts(
        @RequestParam final String nameFilter,
        @RequestParam(required = false, defaultValue = "0") final long page,
        @RequestParam(required = false, defaultValue = "20") final long size
    ) {
        return contactService.findContacts(nameFilter, page, size);
    }

}
