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
/* 015 */   private UnsafeRow scan_result;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 019 */   private scala.collection.immutable.Set filter_hset;
/* 020 */   private boolean filter_hasNull;
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
/* 048 */     scan_result = new UnsafeRow(1);
/* 049 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 050 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 1);
/* 051 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 052 */     filter_hset = ((org.apache.spark.sql.catalyst.expressions.InSet)references[3]).getHSet();
/* 053 */     filter_hasNull = filter_hset.contains(null);
/* 054 */     filter_result = new UnsafeRow(1);
/* 055 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 056 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 1);
/* 057 */     project_result = new UnsafeRow(1);
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private void scan_nextBatch() throws java.io.IOException {
/* 062 */     long getBatchStart = System.nanoTime();
/* 063 */     if (scan_input.hasNext()) {
/* 064 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 065 */       scan_numOutputRows.add(scan_batch.numRows());
/* 066 */       scan_batchIdx = 0;
/* 067 */       scan_colInstance0 = scan_batch.column(0);
/* 068 */
/* 069 */     }
/* 070 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 071 */   }
/* 072 */
/* 073 */   private void wholestagecodegen_init_1() {
/* 074 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 075 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 076 */
/* 077 */   }
/* 078 */
/* 079 */   protected void processNext() throws java.io.IOException {
/* 080 */     if (scan_batch == null) {
/* 081 */       scan_nextBatch();
/* 082 */     }
/* 083 */     while (scan_batch != null) {
/* 084 */       int scan_numRows = scan_batch.numRows();
/* 085 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 086 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 087 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 088 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 089 */         UTF8String scan_value = scan_isNull ? null : (scan_colInstance0.getUTF8String(scan_rowIdx));
/* 090 */
/* 091 */         if (!(!(scan_isNull))) continue;
/* 092 */
/* 093 */         boolean filter_isNull3 = false;
/* 094 */
/* 095 */         UTF8String filter_value3 = null;
/* 096 */         filter_value3 = scan_value.substringSQL(1, 5);
/* 097 */         boolean filter_isNull2 = false;
/* 098 */         boolean filter_value2 = false;
/* 099 */         if (!filter_isNull2) {
/* 100 */           filter_value2 = filter_hset.contains(filter_value3);
/* 101 */           if (!filter_value2 && filter_hasNull) {
/* 102 */             filter_isNull2 = true;
/* 103 */           }
/* 104 */         }
/* 105 */         if (!filter_value2) continue;
/* 106 */         boolean filter_isNull8 = false;
/* 107 */
/* 108 */         UTF8String filter_value8 = null;
/* 109 */         filter_value8 = scan_value.substringSQL(1, 5);
/* 110 */         if (!(!(false))) continue;
/* 111 */
/* 112 */         filter_numOutputRows.add(1);
/* 113 */
/* 114 */         boolean project_isNull = false;
/* 115 */
/* 116 */         UTF8String project_value = null;
/* 117 */         project_value = scan_value.substringSQL(1, 5);
/* 118 */         project_holder.reset();
/* 119 */
/* 120 */         project_rowWriter.write(0, project_value);
/* 121 */         project_result.setTotalSize(project_holder.totalSize());
/* 122 */         append(project_result);
/* 123 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 124 */       }
/* 125 */       scan_batchIdx = scan_numRows;
/* 126 */       scan_batch = null;
/* 127 */       scan_nextBatch();
/* 128 */     }
/* 129 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 130 */     scan_scanTime1 = 0;
/* 131 */   }
/* 132 */ }
