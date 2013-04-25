class User < ActiveRecord::Base
  attr_accessible :email, :nome, :senha
end
