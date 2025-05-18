package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.JournaEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private final Map<Long, JournaEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournaEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournaEntry entry) {
        journalEntries.put(entry.getId(), entry);
        return true;
    }

    @GetMapping("/id/{id}")
    public JournaEntry getById(@PathVariable Long id) {
        return journalEntries.get(id);
    }

    @PutMapping("/id/{id}")
    public JournaEntry updateByID(@PathVariable Long id, @RequestBody JournaEntry entry){
        return journalEntries.put(id,entry);
    }

    @DeleteMapping("/id/{id}")
    public JournaEntry deleteByID(@PathVariable Long id){
        return journalEntries.remove(id);
    }
}
