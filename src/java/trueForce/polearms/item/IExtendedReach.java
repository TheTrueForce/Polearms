package trueForce.polearms.item;

public interface IExtendedReach {
	/**
	 * @return The reach, in blocks, that the item allows. This replaces your player's reach, instead of adding to it.
	 */
	float getReach();
}
