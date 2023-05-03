# Cleanup

1. First empty the S3 bucket, that contains the client source files manually (via AWS Console)
1. Then cleanup all the resources provisioned using SAM run:

        sam delete --no-prompts --profile jaws --stack-name sam-jaws --region eu-central-1

	!!! note
		The deletion of the CloudFront distribution takes longer, than sam delete command is willing to wait, 
                therefor execution of the delete command might fail, but resources would be dropped.
                To check it, either use AWS Console -> CloudFormation section, or run the command repeately.

