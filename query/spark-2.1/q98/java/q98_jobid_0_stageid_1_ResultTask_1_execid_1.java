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
/* 016 */   private UnsafeRow scan_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 020 */   private UnsafeRow filter_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 023 */   private UnsafeRow project_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 026 */
/* 027 */   public GeneratedIterator(Object[] references) {
/* 028 */     this.references = references;
/* 029 */   }
/* 030 */
/* 031 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 032 */     partitionIndex = index;
/* 033 */     this.inputs = inputs;
/* 034 */     wholestagecodegen_init_0();
/* 035 */     wholestagecodegen_init_1();
/* 036 */
/* 037 */   }
/* 038 */
/* 039 */   private void wholestagecodegen_init_0() {
/* 040 */     scan_input = inputs[0];
/* 041 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 042 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 043 */     scan_scanTime1 = 0;
/* 044 */     scan_batch = null;
/* 045 */     scan_batchIdx = 0;
/* 046 */     scan_colInstance0 = null;
/* 047 */     scan_colInstance1 = null;
/* 048 */     scan_result = new UnsafeRow(2);
/* 049 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 050 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 051 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 052 */     filter_result = new UnsafeRow(2);
/* 053 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 054 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 055 */     project_result = new UnsafeRow(1);
/* 056 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void scan_nextBatch() throws java.io.IOException {
/* 061 */     long getBatchStart = System.nanoTime();
/* 062 */     if (scan_input.hasNext()) {
/* 063 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 064 */       scan_numOutputRows.add(scan_batch.numRows());
/* 065 */       scan_batchIdx = 0;
/* 066 */       scan_colInstance0 = scan_batch.column(0);
/* 067 */       scan_colInstance1 = scan_batch.column(1);
/* 068 */
/* 069 */     }
/* 070 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 071 */   }
/* 072 */
/* 073 */   private void wholestagecodegen_init_1() {
/* 074 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */   protected void processNext() throws java.io.IOException {
/* 079 */     if (scan_batch == null) {
/* 080 */       scan_nextBatch();
/* 081 */     }
/* 082 */     while (scan_batch != null) {
/* 083 */       int numRows = scan_batch.numRows();
/* 084 */       while (scan_batchIdx < numRows) {
/* 085 */         int scan_rowIdx = scan_batchIdx++;
/* 086 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 087 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 088 */
/* 089 */         if (!(!(scan_isNull1))) continue;
/* 090 */
/* 091 */         boolean filter_isNull2 = false;
/* 092 */
/* 093 */         Object filter_obj = ((Expression) references[3]).eval(null);
/* 094 */         UTF8String filter_value4 = (UTF8String) filter_obj;
/* 095 */         boolean filter_value2 = false;
/* 096 */         filter_value2 = scan_value1.compare(filter_value4) >= 0;
/* 097 */         if (!filter_value2) continue;
/* 098 */         boolean filter_isNull5 = false;
/* 099 */
/* 100 */         Object filter_obj1 = ((Expression) references[4]).eval(null);
/* 101 */         UTF8String filter_value7 = (UTF8String) filter_obj1;
/* 102 */         boolean filter_value5 = false;
/* 103 */         filter_value5 = scan_value1.compare(filter_value7) <= 0;
/* 104 */         if (!filter_value5) continue;
/* 105 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 106 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 107 */
/* 108 */         if (!(!(scan_isNull))) continue;
/* 109 */
/* 110 */         boolean filter_isNull10 = false;
/* 111 */
/* 112 */         boolean filter_value10 = false;
/* 113 */         filter_value10 = scan_value <= 2452183;
/* 114 */         if (!filter_value10) continue;
/* 115 */         boolean filter_isNull13 = false;
/* 116 */
/* 117 */         boolean filter_value13 = false;
/* 118 */         filter_value13 = scan_value >= 2451911;
/* 119 */         if (!filter_value13) continue;
/* 120 */
/* 121 */         filter_numOutputRows.add(1);
/* 122 */
/* 123 */         project_rowWriter.write(0, scan_value);
/* 124 */         append(project_result);
/* 125 */         if (shouldStop()) return;
/* 126 */       }
/* 127 */       scan_batch = null;
/* 128 */       scan_nextBatch();
/* 129 */     }
/* 130 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 131 */     scan_scanTime1 = 0;
/* 132 */   }
/* 133 */ }
