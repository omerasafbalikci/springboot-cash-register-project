package com.toyota.authenticationauthorizationservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Entity representing an authentication token.
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token {
    @Id
    private String tokenId;

    private boolean revoked;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
