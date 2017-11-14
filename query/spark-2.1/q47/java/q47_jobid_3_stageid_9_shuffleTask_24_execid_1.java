/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 010 */   private UnsafeRow filter_result;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 013 */
/* 014 */   public GeneratedIterator(Object[] references) {
/* 015 */     this.references = references;
/* 016 */   }
/* 017 */
/* 018 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 019 */     partitionIndex = index;
/* 020 */     this.inputs = inputs;
/* 021 */     inputadapter_input = inputs[0];
/* 022 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 023 */     filter_result = new UnsafeRow(9);
/* 024 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 128);
/* 025 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 9);
/* 026 */
/* 027 */   }
/* 028 */
/* 029 */   protected void processNext() throws java.io.IOException {
/* 030 */     while (inputadapter_input.hasNext()) {
/* 031 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 032 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 033 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 034 */
/* 035 */       if (!(!(inputadapter_isNull4))) continue;
/* 036 */
/* 037 */       boolean filter_isNull2 = false;
/* 038 */
/* 039 */       boolean filter_value2 = false;
/* 040 */       filter_value2 = inputadapter_value4 == 1999;
/* 041 */       if (!filter_value2) continue;
/* 042 */
/* 043 */       filter_numOutputRows.add(1);
/* 044 */
/* 045 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 046 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 047 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 048 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 049 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 050 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 051 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 052 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 053 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 054 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 055 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 056 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 057 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 058 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 059 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 060 */       int inputadapter_value8 = inputadapter_isNull8 ? -1 : (inputadapter_row.getInt(8));
/* 061 */       filter_holder.reset();
/* 062 */
/* 063 */       filter_rowWriter.zeroOutNullBytes();
/* 064 */
/* 065 */       if (inputadapter_isNull) {
/* 066 */         filter_rowWriter.setNullAt(0);
/* 067 */       } else {
/* 068 */         filter_rowWriter.write(0, inputadapter_value);
/* 069 */       }
/* 070 */
/* 071 */       if (inputadapter_isNull1) {
/* 072 */         filter_rowWriter.setNullAt(1);
/* 073 */       } else {
/* 074 */         filter_rowWriter.write(1, inputadapter_value1);
/* 075 */       }
/* 076 */
/* 077 */       if (inputadapter_isNull2) {
/* 078 */         filter_rowWriter.setNullAt(2);
/* 079 */       } else {
/* 080 */         filter_rowWriter.write(2, inputadapter_value2);
/* 081 */       }
/* 082 */
/* 083 */       if (inputadapter_isNull3) {
/* 084 */         filter_rowWriter.setNullAt(3);
/* 085 */       } else {
/* 086 */         filter_rowWriter.write(3, inputadapter_value3);
/* 087 */       }
/* 088 */
/* 089 */       filter_rowWriter.write(4, inputadapter_value4);
/* 090 */
/* 091 */       if (inputadapter_isNull5) {
/* 092 */         filter_rowWriter.setNullAt(5);
/* 093 */       } else {
/* 094 */         filter_rowWriter.write(5, inputadapter_value5);
/* 095 */       }
/* 096 */
/* 097 */       if (inputadapter_isNull6) {
/* 098 */         filter_rowWriter.setNullAt(6);
/* 099 */       } else {
/* 100 */         filter_rowWriter.write(6, inputadapter_value6);
/* 101 */       }
/* 102 */
/* 103 */       if (inputadapter_isNull7) {
/* 104 */         filter_rowWriter.setNullAt(7);
/* 105 */       } else {
/* 106 */         filter_rowWriter.write(7, inputadapter_value7);
/* 107 */       }
/* 108 */
/* 109 */       if (inputadapter_isNull8) {
/* 110 */         filter_rowWriter.setNullAt(8);
/* 111 */       } else {
/* 112 */         filter_rowWriter.write(8, inputadapter_value8);
/* 113 */       }
/* 114 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 115 */       append(filter_result);
/* 116 */       if (shouldStop()) return;
/* 117 */     }
/* 118 */   }
/* 119 */ }
