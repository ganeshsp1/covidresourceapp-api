package com.server.coronasafe.models;

public class Timestamp {
private long nanos;
private long seconds;
/**
 * @return the nanos
 */
public long getNanos() {
	return nanos;
}
/**
 * @param nanos the nanos to set
 */
public void setNanos(long nanos) {
	this.nanos = nanos;
}
/**
 * @return the seconds
 */
public long getSeconds() {
	return seconds;
}
/**
 * @param seconds the seconds to set
 */
public void setSeconds(long seconds) {
	this.seconds = seconds;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (nanos ^ (nanos >>> 32));
	result = prime * result + (int) (seconds ^ (seconds >>> 32));
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Timestamp other = (Timestamp) obj;
	if (nanos != other.nanos)
		return false;
	if (seconds != other.seconds)
		return false;
	return true;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Timestamp [nanos=");
	builder.append(nanos);
	builder.append(", seconds=");
	builder.append(seconds);
	builder.append("]");
	return builder.toString();
}
}
