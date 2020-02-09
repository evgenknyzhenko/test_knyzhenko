package app.contacts;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findContacts(final String nameFilter, final long page, final long size) {
        final List<Contact> allContacts = contactRepository.findAll();

        final long skipContactsCount = page * size;

        return allContacts.stream()
            .filter(contact -> !contact.getName().matches(nameFilter))
            .skip(skipContactsCount)
            .limit(size)
            .collect(Collectors.toList());
    }
}
