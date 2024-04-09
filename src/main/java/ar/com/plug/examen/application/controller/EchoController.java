package ar.com.plug.examen.application.controller;

import ar.com.plug.examen.application.dto.out.MessageDto;
import ar.com.plug.examen.domain.service.ProcessMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/echo")
public class EchoController {

    private final ProcessMessageService messageService;

    @Autowired
    public EchoController (ProcessMessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE },
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> echo(@RequestBody MessageDto message)
    {
        return new ResponseEntity<>(messageService.processMessage(message.getMessage()), HttpStatus.OK);
    }
}
