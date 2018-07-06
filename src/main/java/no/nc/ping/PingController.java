package no.nc.ping;

import no.nc.api.PingApi;
import no.nc.model.Pong;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.OffsetDateTime;

@Controller
public class PingController implements PingApi {

    /**
     *  REMARK:
     *  Spring Web does not recognize parameter annotations in interfaces.
     *  Hence the unfortunate duplication in the implementing class.
     */
    @Override
    public ResponseEntity<Pong> ping(@RequestParam(value = "message", required = false) String message) {
        return ResponseEntity.ok(new Pong().message(message).dateAndTime(OffsetDateTime.now()));
    }
}
