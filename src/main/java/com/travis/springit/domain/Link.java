package com.travis.springit.domain;

import com.travis.springit.service.BeanUtil;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
//@Data
@RequiredArgsConstructor
@Getter @Setter
//@ToString
@NoArgsConstructor
public class Link extends Auditable{


    @Id @GeneratedValue
    private long id;

    @NonNull
    @NotEmpty(message = "Please submit a title.")
    private String title;

    @NonNull
    @NotEmpty(message = "Please enter a url.")
    @URL(message="Please submit a valid url.")
    private String url;

    //comments
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "link")
    private List<Vote> votes = new ArrayList<>();

    private int voteCount=0;

    @ManyToOne
    private User user;


    public void addComment(Comment comment){
        comments.add(comment);
    }
    public String getDomainName() throws URISyntaxException {
        URI uri = new URI(this.url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }
}
