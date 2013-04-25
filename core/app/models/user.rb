class User < ActiveRecord::Base
  attr_accessible :email, :name, :password
  validates :email,presence: true, uniqueness: true
  validates :name,presence: true
  validates :password, presence: true,length: {minimum: 3}
end
