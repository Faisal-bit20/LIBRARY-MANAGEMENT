package com.library.service;

import com.library.model.Member;
import com.library.model.Resource;
import com.library.repository.MemberRepository;
import com.library.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private ResourceRepository resourceRepo;

    @Autowired
    private MemberRepository memberRepo;

    // Add resource
    public Resource addResource(Resource resource) {
        return resourceRepo.save(resource);
    }

    // Register member
    public Member registerMember(Member member) {
        return memberRepo.save(member);
    }

    // Borrow resource
    public String borrowResource(String memberId, String resourceId) {
        Optional<Member> member = memberRepo.findById(memberId);
        Optional<Resource> resource = resourceRepo.findById(resourceId);

        if (member.isEmpty() || resource.isEmpty()) {
            return "Invalid Member or Resource ID.";
        }

        Resource res = resource.get();
        if (!res.isAvailable()) {
            return "Resource is currently borrowed.";
        }

        res.setBorrowerId(memberId);
        resourceRepo.save(res);
        return "Resource borrowed successfully.";
    }

    // Return resource
    public String returnResource(String resourceId) {
        Optional<Resource> resource = resourceRepo.findById(resourceId);
        if (resource.isEmpty()) {
            return "Resource not found.";
        }

        Resource res = resource.get();
        res.setBorrowerId(null);
        resourceRepo.save(res);
        return "Resource returned successfully.";
    }

    // List resources
    public List<Resource> getAllResources() {
        return resourceRepo.findAll();
    }

    // List members
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }
}
