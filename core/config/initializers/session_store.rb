# Be sure to restart your server when you modify this file.

# Your secret key for verifying cookie session data integrity.
# If you change this key, all old sessions will become invalid!
# Make sure the secret is at least 30 characters and all random, 
# no regular words or you'll be exposed to dictionary attacks.
ActionController::Base.session = {
  :key         => '_core_session',
  :secret      => '1e49c7926f4df0541276045b0d4ae2fd66314b50330f8e074bf70d2f85ba97935a22078e962d65ced01160c0da3c9103bac1f707948425e9029fee7d537f0492'
}

# Use the database for sessions instead of the cookie-based default,
# which shouldn't be used to store highly confidential information
# (create the session table with "rake db:sessions:create")
# ActionController::Base.session_store = :active_record_store
