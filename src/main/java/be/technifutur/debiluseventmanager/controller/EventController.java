package be.technifutur.debiluseventmanager.controller;

import be.technifutur.debiluseventmanager.model.dto.EventDTO;
import be.technifutur.debiluseventmanager.model.form.EventForm;
import be.technifutur.debiluseventmanager.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvent(@RequestBody @Valid EventForm eventForm) {
        eventService.createEvent(eventForm);
    }

    @PatchMapping("/{id}/update")
    public void updateEvent(@RequestBody EventForm eventForm, @PathVariable Long id) {
        eventService.updateEvent(eventForm, id);
    }

    @PatchMapping("/{id}/addParticipant")
    public void addParticipant(@RequestBody String username, @PathVariable Long id) {
        eventService.addParticipant(username, id);
    }

    @PatchMapping("/{id}/removeParticipant")
    public void removeParticipant(@RequestBody String username, @PathVariable Long id) {
        eventService.removeParticipant(username, id);
    }

    @DeleteMapping("/{id}/delete/{username}")
    public void deleteEvent(@PathVariable Long id, @PathVariable String username) {
        eventService.deleteEvent(id, username);
    }

    @GetMapping("/{id}")
    public EventDTO getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping("/all")
    public List<EventDTO> getAllEvents() {
        return eventService.getAllEvents();
    }
}
