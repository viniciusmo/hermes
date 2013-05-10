require 'digest/md5'

class User < ActiveRecord::Base
  attr_accessible :email, :name, :password, :password_confirmation
  validates :email,presence: true, uniqueness: true
  validates :name,presence: true
  validates :password, presence: true,length: {minimum: 3}
  validates :password, :confirmation => true
  has_many :boards
  
  before_save :encrypt_password
  after_save :create_and_populate_board

  def encrypt_password
  	 if self.password.present? 
  	 	self.password = Digest::MD5.hexdigest(self.password)
  	 end
  end

  def create_and_populate_board
     Board.create  name: "principal",
                   column: 3,
                   line: 3,
                   user_id: self.id
  end

end
