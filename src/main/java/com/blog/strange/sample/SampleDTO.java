package com.blog.strange.sample;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class SampleDTO {
	private long sno;
	private String first;
	private String last;
	private LocalDateTime regTime;
}
