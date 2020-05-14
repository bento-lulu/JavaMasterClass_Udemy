package collections.sets.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dev on 12/01/2016.
 */
public class HeavenlyBody {
	
	public enum BodyType{
		PLANET,
		MOON,
		STAR
	}
	
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    
    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellites(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }
    
    
    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        if ( obj instanceof HeavenlyBody) {
            HeavenlyBody body = (HeavenlyBody) obj;
            return this.key.equals( body.getKey() );
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }
    
    @Override
	public String toString() {
		return this.getKey()+ ", " + orbitalPeriod;
	}
    
    
    
    
    public static Key makeKey( String nome, BodyType bodyType ) {
    	return new Key( nome, bodyType );
    }
    
    
    
    
    public static final class Key {
    	private final String name;
    	private final BodyType bodyType;
    	
    	private Key( String name, BodyType bodyType ) {
    		this.name = name;
    		this.bodyType = bodyType;
    	}
    	
    	public String getName() {
			return name;
		}
    	
    	public BodyType getBodyType() {
			return bodyType;
		}
    	
    	@Override
		public boolean equals(Object obj) {
			if ( this == obj ) {
				return true;
			}
			if ( obj instanceof Key ) {
				Key key = (Key) obj;
				boolean mesmoTypo = (bodyType == key.getBodyType() );
				boolean mesmoNome = (name == key.getName() );
				
				if ( mesmoTypo && mesmoNome ) {
					return true;
				}
			}
			return false;
		}
    	
    	@Override
		public int hashCode() {
			return this.name.hashCode() + 57 + this.bodyType.hashCode();
		}
    	
    	@Override
		public String toString() {
			return this.name + ": " +this.bodyType;
		}
    	
    }
    
    
}



