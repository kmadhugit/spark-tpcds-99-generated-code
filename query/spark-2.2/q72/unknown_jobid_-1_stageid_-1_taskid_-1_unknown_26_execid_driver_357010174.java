/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter1;
/* 013 */
/* 014 */   public SpecificUnsafeProjection(Object[] references) {
/* 015 */     this.references = references;
/* 016 */     result = new UnsafeRow(1);
/* 017 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 32);
/* 018 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 019 */     this.arrayWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 020 */     this.rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 2);
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */   public void initialize(int partitionIndex) {
/* 025 */
/* 026 */   }
/* 027 */
/* 028 */
/* 029 */
/* 030 */   // Scala.Function1 need this
/* 031 */   public java.lang.Object apply(java.lang.Object row) {
/* 032 */     return apply((InternalRow) row);
/* 033 */   }
/* 034 */
/* 035 */   public UnsafeRow apply(InternalRow i) {
/* 036 */     holder.reset();
/* 037 */
/* 038 */     rowWriter.zeroOutNullBytes();
/* 039 */
/* 040 */
/* 041 */     boolean isNull = i.isNullAt(0);
/* 042 */     ArrayData value = isNull ? null : (i.getArray(0));
/* 043 */     if (isNull) {
/* 044 */       rowWriter.setNullAt(0);
/* 045 */     } else {
/* 046 */       // Remember the current cursor so that we can calculate how many bytes are
/* 047 */       // written later.
/* 048 */       final int tmpCursor = holder.cursor;
/* 049 */
/* 050 */       if (value instanceof UnsafeArrayData) {
/* 051 */
/* 052 */         final int sizeInBytes1 = ((UnsafeArrayData) value).getSizeInBytes();
/* 053 */         // grow the global buffer before writing data.
/* 054 */         holder.grow(sizeInBytes1);
/* 055 */         ((UnsafeArrayData) value).writeToMemory(holder.buffer, holder.cursor);
/* 056 */         holder.cursor += sizeInBytes1;
/* 057 */
/* 058 */       } else {
/* 059 */         final int numElements = value.numElements();
/* 060 */         arrayWriter.initialize(holder, numElements, 8);
/* 061 */
/* 062 */         for (int index = 0; index < numElements; index++) {
/* 063 */           if (value.isNullAt(index)) {
/* 064 */             arrayWriter.setNull(index);
/* 065 */           } else {
/* 066 */             final InternalRow element = value.getStruct(index, 2);
/* 067 */
/* 068 */             final int tmpCursor1 = holder.cursor;
/* 069 */
/* 070 */             if (element instanceof UnsafeRow) {
/* 071 */
/* 072 */               final int sizeInBytes = ((UnsafeRow) element).getSizeInBytes();
/* 073 */               // grow the global buffer before writing data.
/* 074 */               holder.grow(sizeInBytes);
/* 075 */               ((UnsafeRow) element).writeToMemory(holder.buffer, holder.cursor);
/* 076 */               holder.cursor += sizeInBytes;
/* 077 */
/* 078 */             } else {
/* 079 */               rowWriter1.reset();
/* 080 */
/* 081 */
/* 082 */               boolean isNull1 = element.isNullAt(0);
/* 083 */               UTF8String value1 = isNull1 ? null : element.getUTF8String(0);
/* 084 */
/* 085 */               if (isNull1) {
/* 086 */                 rowWriter1.setNullAt(0);
/* 087 */               } else {
/* 088 */                 rowWriter1.write(0, value1);
/* 089 */               }
/* 090 */
/* 091 */
/* 092 */               boolean isNull2 = element.isNullAt(1);
/* 093 */               UTF8String value2 = isNull2 ? null : element.getUTF8String(1);
/* 094 */
/* 095 */               if (isNull2) {
/* 096 */                 rowWriter1.setNullAt(1);
/* 097 */               } else {
/* 098 */                 rowWriter1.write(1, value2);
/* 099 */               }
/* 100 */             }
/* 101 */
/* 102 */             arrayWriter.setOffsetAndSize(index, tmpCursor1, holder.cursor - tmpCursor1);
/* 103 */
/* 104 */           }
/* 105 */         }
/* 106 */       }
/* 107 */
/* 108 */       rowWriter.setOffsetAndSize(0, tmpCursor, holder.cursor - tmpCursor);
/* 109 */     }
/* 110 */     result.setTotalSize(holder.totalSize());
/* 111 */     return result;
/* 112 */   }
/* 113 */ }
