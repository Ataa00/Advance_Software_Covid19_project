package Advance.example.Advance.controllers;


import Advance.example.Advance.Model.JwtRequest;
import Advance.example.Advance.Model.JwtResponse;
import Advance.example.Advance.servieces.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/authenticate")
@CrossOrigin(origins = "http://localhost:3000")

public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
