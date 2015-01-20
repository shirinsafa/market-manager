!function (a) {
    a.Editable.commands = a.extend(a.Editable.commands, {uploadFile:{title:"Upload File", icon:"fa fa-paperclip"}}), a.Editable.prototype.cmds_without_focus.push("uploadFile"), a.Editable.prototype.execCommand = a.extend(a.Editable.prototype.execCommand, {uploadFile:function () {
        this.insertFile()
    }}), a.Editable.DEFAULTS = a.extend(a.Editable.DEFAULTS, {allowedFileTypes:["*"], fileDeleteUrl:null, fileDeleteParams:{}, fileUploadParams:{}, fileUploadURL:"http://i.froala.com/upload", fileUploadParam:"file", maxFileSize:10485760}), a.Editable.prototype.showFileWrapper = function () {
        this.$file_wrapper && this.$file_wrapper.show()
    }, a.Editable.prototype.hideFileWrapper = function () {
        this.$file_wrapper && this.$file_wrapper.hide()
    }, a.Editable.prototype.showFileUpload = function () {
        this.hidePopups(), this.showFileWrapper()
    }, a.Editable.prototype.insertFile = function () {
        this.closeImageMode(), this.imageMode = !1, this.showFileUpload(), this.saveSelection(), this.options.inlineMode || this.positionPopup("uploadFile")
    }, a.Editable.prototype.fileUploadHTML = function () {
        var b = '<div class="froala-popup froala-file-popup" style="display: none;"><h4><span data-text="true">Upload file</span><i title="Cancel" class="fa fa-times" id="f-file-close-' + this._id + '"></i></h4>';
        return b += '<div id="f-file-list-' + this._id + '">', this.options.imageUpload && (b += '<div class="f-popup-line drop-upload">', b += '<div class="f-upload" id="f-file-upload-div-' + this._id + '"><strong data-text="true">Drop File</strong><br>(<span data-text="true">or click</span>)<form target="file-frame-' + this._id + '" enctype="multipart/form-data" encoding="multipart/form-data" action="' + this.options.fileUploadURL + '" method="post" id="f-file-form-' + this._id + '"><input id="f-file-upload-' + this._id + '" type="file" name="' + this.options.fileUploadParam + '" accept="/*"></form></div>', this.browser.msie && a.Editable.getIEversion() <= 9 && (b += '<iframe id="file-frame-' + this._id + '" name="file-frame-' + this._id + '" src="javascript:false;" style="width:0; height:0; border:0px solid #FFF; position: fixed; z-index: -1;" data-loaded="true"></iframe>'), b += "</div>"), b += "</div>", b += '<p class="f-progress" id="f-file-progress-' + this._id + '"><span></span></p>', b += "</div>"
    }, a.Editable.prototype.buildFileUpload = function () {
        this.$file_wrapper = a(this.fileUploadHTML()), this.$popup_editor.append(this.$file_wrapper);
        var b = this;
        if (this.addListener("hidePopups", a.proxy(function () {
            this.hideFileWrapper()
        }), this), this.$file_progress_bar = this.$file_wrapper.find("p#f-file-progress-" + this._id), this.browser.msie && a.Editable.getIEversion() <= 9) {
            var c = this.$file_wrapper.find("iframe").get(0);
            c.attachEvent ? c.attachEvent("onload", function () {
                b.iFrameLoad()
            }) : c.onload = function () {
                b.iFrameLoad()
            }
        }
        this.$file_wrapper.on("change", 'input[type="file"]', function () {
            if (void 0 !== this.files)b.uploadFile(this.files); else {
                var c = a(this).parents("form");
                c.find('input[type="hidden"]').remove();
                var d;
                for (d in b.options.fileUploadParams)c.prepend('<input type="hidden" name="' + d + '" value="' + b.options.fileUploadParams[d] + '" />');
                b.$file_wrapper.find("#f-file-list-" + b._id).hide(), b.$file_progress_bar.show(), b.$file_progress_bar.find("span").css("width", "100%").text("Please wait!"), b.showFileUpload(), c.submit()
            }
            a(this).val("")
        }), this.buildDragUpload(), this.$file_wrapper.on("click", "#f-file-close-" + this._id, a.proxy(function () {
            this.$bttn_wrapper.show(), this.hideFileWrapper(), this.restoreSelection(), this.hide()
        }, this)), this.$file_wrapper.on("click", function (a) {
            a.stopPropagation()
        }), this.$file_wrapper.on("click", "*", function (a) {
            a.stopPropagation()
        })
    }, a.Editable.initializers.push(a.Editable.prototype.buildFileUpload), a.Editable.prototype.uploadFile = function (b) {
        if (!this.triggerEvent("beforeFileUpload", [b], !1))return!1;
        if (void 0 !== b && b.length > 0) {
            var c;
            if (this.drag_support.formdata && (c = this.drag_support.formdata ? new FormData : null), c) {
                var d;
                for (d in this.options.fileUploadParams)c.append(d, this.options.fileUploadParams[d]);
                if (c.append(this.options.fileUploadParam, b[0]), b[0].size > this.options.maxFileSize)return this.throwFileError(5), !1;
                if (this.options.allowedFileTypes.indexOf(b[0].type) < 0 && this.options.allowedFileTypes.indexOf("*") < 0)return this.throwFileError(6), !1
            }
            if (c) {
                var e;
                this.options.crossDomain ? e = this.createCORSRequest("POST", this.options.fileUploadURL) : (e = new XMLHttpRequest, e.open("POST", this.options.fileUploadURL));
                var f = b[0].name;
                e.onload = a.proxy(function () {
                    this.$file_progress_bar.find("span").css("width", "100%").text("Please wait!");
                    try {
                        e.status >= 200 && e.status < 300 ? this.parseFileResponse(e.responseText, f) : this.throwFileError(3)
                    } catch (a) {
                        this.throwFileError(4)
                    }
                }, this), e.onerror = a.proxy(function () {
                    this.throwFileError(3)
                }, this), e.upload.onprogress = a.proxy(function (a) {
                    if (a.lengthComputable) {
                        var b = a.loaded / a.total * 100 | 0;
                        this.$file_progress_bar.find("span").css("width", b + "%")
                    }
                }, this), e.send(c), this.$file_wrapper.find("#f-file-list-" + this._id).hide(), this.$file_progress_bar.show(), this.showFileUpload()
            }
        }
    }, a.Editable.prototype.throwFileError = function (a) {
        var b = "Unknown file upload error.";
        1 == a ? b = "Bad link." : 2 == a ? b = "No link in upload response." : 3 == a ? b = "Error during file upload." : 4 == a ? b = "Parsing response failed." : 5 == a ? b = "File too large." : 6 == a ? b = "Invalid file type." : 7 == a && (b = "File can be uploaded only to same domain in IE 8 and IE 9."), this.triggerEvent("fileError", [
            {code:a, message:b}
        ], !1), this.hideFileLoader()
    }, a.Editable.prototype.hideFileLoader = function () {
        this.$file_progress_bar.hide(), this.$file_progress_bar.find("span").css("width", "0%").text(""), this.$file_wrapper.find("#f-file-list-" + this._id).show()
    }, a.Editable.prototype.throwFileErrorWithMessage = function (a) {
        this.triggerEvent("fileError", [
            {message:a, code:0}
        ], !1), this.hideFileLoader()
    }, a.Editable.prototype.parseFileResponse = function (b, c) {
        try {
            var d = a.parseJSON(b);
            d.link ? this.writeFile(d.link, c) : d.error ? this.throwFileErrorWithMessage(d.error) : this.throwFileError(2)
        } catch (e) {
            this.throwFileError(4)
        }
    }, a.Editable.prototype.writeFile = function (a, b) {
        this.restoreSelection(), this.focus(), this.insertHTML('<a class="fr-file" href="' + this.sanitizeURL(a) + '">' + b + "</a>"), this.hide(), this.hideFileLoader(), this.saveUndoStep(), this.focus(), this.wrapText(), this.triggerEvent("fileUploaded", [b, a])
    }
}(jQuery);