//package sn.edu.isepdiamniadio.coursspring.controller.rest;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import sn.edu.isepdiamniadio.coursspring.controller.dto.EcoleDTO;
//import sn.edu.isepdiamniadio.coursspring.domain.Ecole;
//import sn.edu.isepdiamniadio.coursspring.service.EcoleService;
//
//@RestController
//@RequestMapping("/api/v1")
//public class EcoleController {
//
//    @Autowired
//    EcoleService ecoleService;
//
//    @GetMapping(value = "/ecole", produces = MediaType.APPLICATION_JSON_VALUE)
//public ResponseEntity<EcoleDTO> getEcole(@RequestParam String search) {
//        EcoleDTO ecoleDTO = new EcoleDTO();
//        Ecole ecole = new Ecole();
//        if("ISEP".equals(search)){
//
//            ecole.setId(1L);
//            ecole.setNom("ISEP");
//            ecole.setAdresse("Diamniadio");
//            ecoleDTO.setEcole(ecole);
//            ecoleDTO.setMessage("Bravoo j'ai trouvé ton ecole !");
//
//            return ResponseEntity.ok(ecoleDTO);
//        }
//        else {
//            ecoleDTO.setMessage("Dommage nous n'avons pas trouvé ton ecole !!");
//            return ResponseEntity.status(404).body(ecoleDTO);
//        }
//
//
//
//    //return ResponseEntity.status(200).body(ecole);
//
//
//}
//
//    @GetMapping(value = "/ecole/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<EcoleDTO> getOneEcole(@PathVariable int id, @RequestHeader(value = "X-Telephone", required = false) String telephone, @RequestHeader("User-Agent") String userAgent, HttpServletResponse response) {
//
//        Cookie cookie = new Cookie("name","quelqun");
//
//        response.addCookie(cookie);
//        System.out.println("Le type navigateur est:"+ userAgent );
//        System.out.println("Le numero de tel est:"+ telephone );
//
//        EcoleDTO  ecoleDTO = ecoleService.getOneEcole(id, userAgent);
//
//            return ecoleDTO.getEcole() != null ?
//                    ResponseEntity.status(HttpStatus.OK).body(ecoleDTO ):
//                    ResponseEntity.status(404).body(ecoleDTO);
//
//        //return ResponseEntity.status(200).body(ecole);
//
//    }
//
//
//@PostMapping("/ecole")
//public ResponseEntity<Ecole> saveSchool(@RequestBody  Ecole school){
//        school.setId(school.getId()+1);
//      return ResponseEntity.status(HttpStatus.CREATED).body(school);
//}
//}
