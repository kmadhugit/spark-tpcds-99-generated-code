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
/* 027 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 028 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation;
/* 029 */   private UnsafeRow bhj_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 033 */   private UnsafeRow bhj_result1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 036 */   private UnsafeRow project_result1;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 039 */
/* 040 */   public GeneratedIterator(Object[] references) {
/* 041 */     this.references = references;
/* 042 */   }
/* 043 */
/* 044 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 045 */     partitionIndex = index;
/* 046 */     this.inputs = inputs;
/* 047 */     wholestagecodegen_init_0();
/* 048 */     wholestagecodegen_init_1();
/* 049 */     wholestagecodegen_init_2();
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   private void wholestagecodegen_init_0() {
/* 054 */     scan_input = inputs[0];
/* 055 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 056 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 057 */     scan_scanTime1 = 0;
/* 058 */     scan_batch = null;
/* 059 */     scan_batchIdx = 0;
/* 060 */     scan_colInstance0 = null;
/* 061 */     scan_colInstance1 = null;
/* 062 */     scan_colInstance2 = null;
/* 063 */     scan_result = new UnsafeRow(3);
/* 064 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 065 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 066 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 067 */     filter_result = new UnsafeRow(3);
/* 068 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 069 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 070 */     project_result = new UnsafeRow(3);
/* 071 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 072 */
/* 073 */   }
/* 074 */
/* 075 */   private void scan_nextBatch() throws java.io.IOException {
/* 076 */     long getBatchStart = System.nanoTime();
/* 077 */     if (scan_input.hasNext()) {
/* 078 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 079 */       scan_numOutputRows.add(scan_batch.numRows());
/* 080 */       scan_batchIdx = 0;
/* 081 */       scan_colInstance0 = scan_batch.column(0);
/* 082 */       scan_colInstance1 = scan_batch.column(1);
/* 083 */       scan_colInstance2 = scan_batch.column(2);
/* 084 */
/* 085 */     }
/* 086 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 087 */   }
/* 088 */
/* 089 */   private void wholestagecodegen_init_2() {
/* 090 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 091 */
/* 092 */   }
/* 093 */
/* 094 */   private void wholestagecodegen_init_1() {
/* 095 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 096 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 097 */
/* 098 */     bhj_relation = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 099 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 100 */
/* 101 */     bhj_result = new UnsafeRow(1);
/* 102 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 103 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 1);
/* 104 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 105 */     bhj_result1 = new UnsafeRow(5);
/* 106 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 107 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 108 */     project_result1 = new UnsafeRow(1);
/* 109 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 110 */
/* 111 */   }
/* 112 */
/* 113 */   protected void processNext() throws java.io.IOException {
/* 114 */     if (scan_batch == null) {
/* 115 */       scan_nextBatch();
/* 116 */     }
/* 117 */     while (scan_batch != null) {
/* 118 */       int scan_numRows = scan_batch.numRows();
/* 119 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 120 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 121 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 122 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 123 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 124 */
/* 125 */         if (!(!(scan_isNull1))) continue;
/* 126 */
/* 127 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 128 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 129 */
/* 130 */         if (!(!(scan_isNull))) continue;
/* 131 */
/* 132 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 133 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 134 */
/* 135 */         if (!(!(scan_isNull2))) continue;
/* 136 */
/* 137 */         filter_numOutputRows.add(1);
/* 138 */
/* 139 */         // generate join key for stream side
/* 140 */
/* 141 */         bhj_holder.reset();
/* 142 */
/* 143 */         bhj_rowWriter.write(0, scan_value2);
/* 144 */         bhj_result.setTotalSize(bhj_holder.totalSize());
/* 145 */
/* 146 */         // find matches from HashedRelation
/* 147 */         UnsafeRow bhj_matched = bhj_result.anyNull() ? null: (UnsafeRow)bhj_relation.getValue(bhj_result);
/* 148 */         if (bhj_matched == null) continue;
/* 149 */
/* 150 */         double bhj_value1 = bhj_matched.getDouble(0);
/* 151 */
/* 152 */         boolean bhj_isNull3 = true;
/* 153 */         boolean bhj_value3 = false;
/* 154 */
/* 155 */         if (!false) {
/* 156 */           boolean bhj_isNull5 = false;
/* 157 */
/* 158 */           double bhj_value5 = -1.0;
/* 159 */           bhj_value5 = 1.2D * bhj_value1;
/* 160 */
/* 161 */           bhj_isNull3 = false; // resultCode could change nullability.
/* 162 */           bhj_value3 = org.apache.spark.util.Utils.nanSafeCompareDoubles(scan_value1, bhj_value5) > 0;
/* 163 */
/* 164 */         }
/* 165 */         if (bhj_isNull3 || !bhj_value3) continue;
/* 166 */
/* 167 */         bhj_numOutputRows.add(1);
/* 168 */
/* 169 */         project_rowWriter1.write(0, scan_value);
/* 170 */         append(project_result1);
/* 171 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 172 */       }
/* 173 */       scan_batchIdx = scan_numRows;
/* 174 */       scan_batch = null;
/* 175 */       scan_nextBatch();
/* 176 */     }
/* 177 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 178 */     scan_scanTime1 = 0;
/* 179 */   }
/* 180 */ }
