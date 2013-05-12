#Let's just save all this as /test/factories
 FactoryGirl.define do
	 factory :user do
	   name 'QA'
	   email 'teste@teste.com.br'
	   password '123'
	 end
         factory :board do
           name 'Board QA'
           column 1
           line 1
           user_id 1
	 end
 end
