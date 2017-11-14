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
/* 023 */     filter_result = new UnsafeRow(10);
/* 024 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 160);
/* 025 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 10);
/* 026 */
/* 027 */   }
/* 028 */
/* 029 */   protected void processNext() throws java.io.IOException {
/* 030 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 031 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 032 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 033 */       int inputadapter_value9 = inputadapter_isNull9 ? -1 : (inputadapter_row.getInt(9));
/* 034 */
/* 035 */       if (!(!(inputadapter_isNull9))) continue;
/* 036 */
/* 037 */       boolean filter_isNull2 = false;
/* 038 */
/* 039 */       boolean filter_value2 = false;
/* 040 */       filter_value2 = inputadapter_value9 <= 100;
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
/* 053 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 054 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 055 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 056 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 057 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 058 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 059 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 060 */       UTF8String inputadapter_value7 = inputadapter_isNull7 ? null : (inputadapter_row.getUTF8String(7));
/* 061 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 062 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 063 */       filter_holder.reset();
/* 064 */
/* 065 */       filter_rowWriter.zeroOutNullBytes();
/* 066 */
/* 067 */       if (inputadapter_isNull) {
/* 068 */         filter_rowWriter.setNullAt(0);
/* 069 */       } else {
/* 070 */         filter_rowWriter.write(0, inputadapter_value);
/* 071 */       }
/* 072 */
/* 073 */       if (inputadapter_isNull1) {
/* 074 */         filter_rowWriter.setNullAt(1);
/* 075 */       } else {
/* 076 */         filter_rowWriter.write(1, inputadapter_value1);
/* 077 */       }
/* 078 */
/* 079 */       if (inputadapter_isNull2) {
/* 080 */         filter_rowWriter.setNullAt(2);
/* 081 */       } else {
/* 082 */         filter_rowWriter.write(2, inputadapter_value2);
/* 083 */       }
/* 084 */
/* 085 */       if (inputadapter_isNull3) {
/* 086 */         filter_rowWriter.setNullAt(3);
/* 087 */       } else {
/* 088 */         filter_rowWriter.write(3, inputadapter_value3);
/* 089 */       }
/* 090 */
/* 091 */       if (inputadapter_isNull4) {
/* 092 */         filter_rowWriter.setNullAt(4);
/* 093 */       } else {
/* 094 */         filter_rowWriter.write(4, inputadapter_value4);
/* 095 */       }
/* 096 */
/* 097 */       if (inputadapter_isNull5) {
/* 098 */         filter_rowWriter.setNullAt(5);
/* 099 */       } else {
/* 100 */         filter_rowWriter.write(5, inputadapter_value5);
/* 101 */       }
/* 102 */
/* 103 */       if (inputadapter_isNull6) {
/* 104 */         filter_rowWriter.setNullAt(6);
/* 105 */       } else {
/* 106 */         filter_rowWriter.write(6, inputadapter_value6);
/* 107 */       }
/* 108 */
/* 109 */       if (inputadapter_isNull7) {
/* 110 */         filter_rowWriter.setNullAt(7);
/* 111 */       } else {
/* 112 */         filter_rowWriter.write(7, inputadapter_value7);
/* 113 */       }
/* 114 */
/* 115 */       if (inputadapter_isNull8) {
/* 116 */         filter_rowWriter.setNullAt(8);
/* 117 */       } else {
/* 118 */         filter_rowWriter.write(8, inputadapter_value8);
/* 119 */       }
/* 120 */
/* 121 */       filter_rowWriter.write(9, inputadapter_value9);
/* 122 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 123 */       append(filter_result);
/* 124 */       if (shouldStop()) return;
/* 125 */     }
/* 126 */   }
/* 127 */ }
