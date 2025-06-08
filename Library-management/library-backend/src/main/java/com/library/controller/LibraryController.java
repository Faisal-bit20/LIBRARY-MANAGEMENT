package com.library.controller;

import com.library.model.Member;
import com.library.model.Resource;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*") // allows frontend access from any origin
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/resources")
    public Resource addResource(@RequestBody Resource resource) {
        return libraryService.addResource(resource);
    }

    @PostMapping("/members")
    public Member registerMember(@RequestBody Member member) {
        return libraryService.registerMember(member);
    }

    @PutMapping("/resources/{resourceId}/borrow/{memberId}")
    public String borrowResource(@PathVariable String resourceId, @PathVariable String memberId) {
        return libraryService.borrowResource(memberId, resourceId);
    }

    @PutMapping("/resources/{resourceId}/return")
    public String returnResource(@PathVariable String resourceId) {
        return libraryService.returnResource(resourceId);
    }

    @GetMapping("/resources")
    public List<Resource> getAllResources() {
        return libraryService.getAllResources();
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return libraryService.getAllMembers();
    }
}
