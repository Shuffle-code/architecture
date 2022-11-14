package geekbrains.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    OK("OK"),
    CREATED("CREATED"),
    NOT_FOUND("NOT_FOUND");
    private final String title;
}
