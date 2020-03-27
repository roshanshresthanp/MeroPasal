<%-- 
    Document   : confirmdelete
    Created on : Dec 12, 2019, 11:22:42 AM
    Author     : ROSHAB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="model fade" id="confirm_delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        
        <div class="model-content">
            <div class="model-header">Delete Confirmation
            </div>
            <div class="model-body">Do you want to delete this record permanently?
            </div>
            <div class="model-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a class="btn btn-danger btn-ok">Delete</a> 
            </div>
        </div>
            
    </div>
</div>
<script>
    $('#confirm_delete').on('show.bs.modal',function(e){
        $(this).find('.btn-ok').attr('href',$(e.relatedTarget.data('href'));
    });
    </script>