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
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter1;
/* 012 */
/* 013 */   public SpecificUnsafeProjection(Object[] references) {
/* 014 */     this.references = references;
/* 015 */     result = new UnsafeRow(1);
/* 016 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 32);
/* 017 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 018 */     this.rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 2);
/* 019 */
/* 020 */   }
/* 021 */
/* 022 */   public void initialize(int partitionIndex) {
/* 023 */
/* 024 */   }
/* 025 */
/* 026 */
/* 027 */
/* 028 */   // Scala.Function1 need this
/* 029 */   public java.lang.Object apply(java.lang.Object row) {
/* 030 */     return apply((InternalRow) row);
/* 031 */   }
/* 032 */
/* 033 */   public UnsafeRow apply(InternalRow i) {
/* 034 */     holder.reset();
/* 035 */
/* 036 */     rowWriter.zeroOutNullBytes();
/* 037 */
/* 038 */
/* 039 */     boolean isNull = i.isNullAt(0);
/* 040 */     InternalRow value = isNull ? null : (i.getStruct(0, 2));
/* 041 */     if (isNull) {
/* 042 */       rowWriter.setNullAt(0);
/* 043 */     } else {
/* 044 */       // Remember the current cursor so that we can calculate how many bytes are
/* 045 */       // written later.
/* 046 */       final int tmpCursor = holder.cursor;
/* 047 */
/* 048 */       if (value instanceof UnsafeRow) {
/* 049 */
/* 050 */         final int sizeInBytes = ((UnsafeRow) value).getSizeInBytes();
/* 051 */         // grow the global buffer before writing data.
/* 052 */         holder.grow(sizeInBytes);
/* 053 */         ((UnsafeRow) value).writeToMemory(holder.buffer, holder.cursor);
/* 054 */         holder.cursor += sizeInBytes;
/* 055 */
/* 056 */       } else {
/* 057 */         rowWriter1.reset();
/* 058 */
/* 059 */
/* 060 */         boolean isNull1 = value.isNullAt(0);
/* 061 */         UTF8String value1 = isNull1 ? null : value.getUTF8String(0);
/* 062 */
/* 063 */         if (isNull1) {
/* 064 */           rowWriter1.setNullAt(0);
/* 065 */         } else {
/* 066 */           rowWriter1.write(0, value1);
/* 067 */         }
/* 068 */
/* 069 */
/* 070 */         boolean isNull2 = value.isNullAt(1);
/* 071 */         UTF8String value2 = isNull2 ? null : value.getUTF8String(1);
/* 072 */
/* 073 */         if (isNull2) {
/* 074 */           rowWriter1.setNullAt(1);
/* 075 */         } else {
/* 076 */           rowWriter1.write(1, value2);
/* 077 */         }
/* 078 */       }
/* 079 */
/* 080 */       rowWriter.setOffsetAndSize(0, tmpCursor, holder.cursor - tmpCursor);
/* 081 */     }
/* 082 */     result.setTotalSize(holder.totalSize());
/* 083 */     return result;
/* 084 */   }
/* 085 */ }
