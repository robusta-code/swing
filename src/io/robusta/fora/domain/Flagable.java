package io.robusta.fora.domain;

import java.util.List;

public interface Flagable {

	public boolean isFlagged();
	public List<? extends Flag> getFlags();
	
}
