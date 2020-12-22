package com.travis.springit.service;

import com.travis.springit.domain.User;
import com.travis.springit.domain.Vote;
import com.travis.springit.repository.VoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote save(Vote vote){
        return voteRepository.save(vote);
    }


}
