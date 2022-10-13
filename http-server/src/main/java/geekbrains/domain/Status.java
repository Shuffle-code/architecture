package geekbrains.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    OK("OK"),
    CREATED("CREATED"),
    METHOD_NOT_ALLOWED("METHOD_NOT_ALLOWED"),
    NOT_FOUND("NOT_FOUND");
    private final String title;
}
