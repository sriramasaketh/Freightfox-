-- Table to store distance information between pincodes
CREATE TABLE distances (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    from_pincode VARCHAR(6) NOT NULL,
    to_pincode VARCHAR(6) NOT NULL,
    distance DOUBLE NOT NULL,
    duration VARCHAR(50) NOT NULL,
    route TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Optional: Table to store pincode information, including lat, long, and polygon
CREATE TABLE pincodes (
    pincode VARCHAR(6) PRIMARY KEY,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    polygon TEXT
);

-- Index for faster lookup on from_pincode and to_pincode in distances table
CREATE INDEX idx_from_to_pincode ON distances (from_pincode, to_pincode);

-- Example data (you can remove or keep these for testing)
-- INSERT INTO pincodes (pincode, latitude, longitude, polygon) VALUES ('141106', 30.9010, 75.8573, NULL);
-- INSERT INTO pincodes (pincode, latitude, longitude, polygon) VALUES ('110060', 28.6358, 77.2244, NULL);
