/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private UnsafeRow scan_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 021 */   private UnsafeRow filter_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     wholestagecodegen_init_0();
/* 036 */     wholestagecodegen_init_1();
/* 037 */
/* 038 */   }
/* 039 */
/* 040 */   private void wholestagecodegen_init_0() {
/* 041 */     scan_input = inputs[0];
/* 042 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     scan_scanTime1 = 0;
/* 045 */     scan_batch = null;
/* 046 */     scan_batchIdx = 0;
/* 047 */     scan_colInstance0 = null;
/* 048 */     scan_colInstance1 = null;
/* 049 */     scan_colInstance2 = null;
/* 050 */     scan_result = new UnsafeRow(3);
/* 051 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 052 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 053 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     filter_result = new UnsafeRow(3);
/* 055 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 056 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 057 */     project_result = new UnsafeRow(1);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */   private void scan_nextBatch() throws java.io.IOException {
/* 063 */     long getBatchStart = System.nanoTime();
/* 064 */     if (scan_input.hasNext()) {
/* 065 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 066 */       scan_numOutputRows.add(scan_batch.numRows());
/* 067 */       scan_batchIdx = 0;
/* 068 */       scan_colInstance0 = scan_batch.column(0);
/* 069 */       scan_colInstance1 = scan_batch.column(1);
/* 070 */       scan_colInstance2 = scan_batch.column(2);
/* 071 */
/* 072 */     }
/* 073 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 074 */   }
/* 075 */
/* 076 */   private void wholestagecodegen_init_1() {
/* 077 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   protected void processNext() throws java.io.IOException {
/* 082 */     if (scan_batch == null) {
/* 083 */       scan_nextBatch();
/* 084 */     }
/* 085 */     while (scan_batch != null) {
/* 086 */       int scan_numRows = scan_batch.numRows();
/* 087 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 088 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 089 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 090 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 091 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 092 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 093 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 094 */
/* 095 */         boolean filter_isNull1 = true;
/* 096 */         boolean filter_value1 = false;
/* 097 */
/* 098 */         if (!scan_isNull1) {
/* 099 */           filter_isNull1 = false; // resultCode could change nullability.
/* 100 */           filter_value1 = scan_value1.equals(((UTF8String) references[3]));
/* 101 */
/* 102 */         }
/* 103 */         boolean filter_isNull = false;
/* 104 */         boolean filter_value = true;
/* 105 */
/* 106 */         if (!filter_isNull1 && filter_value1) {
/* 107 */         } else {
/* 108 */           boolean filter_isNull4 = true;
/* 109 */           boolean filter_value4 = false;
/* 110 */
/* 111 */           if (!scan_isNull2) {
/* 112 */             filter_isNull4 = false; // resultCode could change nullability.
/* 113 */             filter_value4 = scan_value2.equals(((UTF8String) references[4]));
/* 114 */
/* 115 */           }
/* 116 */           if (!filter_isNull4 && filter_value4) {
/* 117 */           } else if (!filter_isNull1 && !filter_isNull4) {
/* 118 */             filter_value = false;
/* 119 */           } else {
/* 120 */             filter_isNull = true;
/* 121 */           }
/* 122 */         }
/* 123 */         if (filter_isNull || !filter_value) continue;
/* 124 */
/* 125 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 126 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 127 */
/* 128 */         if (!(!(scan_isNull))) continue;
/* 129 */
/* 130 */         filter_numOutputRows.add(1);
/* 131 */
/* 132 */         project_rowWriter.write(0, scan_value);
/* 133 */         append(project_result);
/* 134 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 135 */       }
/* 136 */       scan_batchIdx = scan_numRows;
/* 137 */       scan_batch = null;
/* 138 */       scan_nextBatch();
/* 139 */     }
/* 140 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 141 */     scan_scanTime1 = 0;
/* 142 */   }
/* 143 */ }
