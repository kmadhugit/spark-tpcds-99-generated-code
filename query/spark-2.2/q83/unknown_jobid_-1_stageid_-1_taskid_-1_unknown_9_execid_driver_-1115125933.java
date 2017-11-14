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
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 024 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance18;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance19;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance20;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance21;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance22;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance23;
/* 038 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance24;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance25;
/* 040 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance26;
/* 041 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance27;
/* 042 */   private UnsafeRow scan_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 046 */   private UnsafeRow filter_result;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 049 */   private UnsafeRow project_result;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 052 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 053 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation;
/* 054 */   private UnsafeRow bhj_result;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 057 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 058 */   private UnsafeRow bhj_result1;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 061 */   private UnsafeRow project_result1;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 064 */
/* 065 */   public GeneratedIterator(Object[] references) {
/* 066 */     this.references = references;
/* 067 */   }
/* 068 */
/* 069 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 070 */     partitionIndex = index;
/* 071 */     this.inputs = inputs;
/* 072 */     wholestagecodegen_init_0();
/* 073 */     wholestagecodegen_init_1();
/* 074 */     wholestagecodegen_init_2();
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */   private void wholestagecodegen_init_0() {
/* 079 */     scan_input = inputs[0];
/* 080 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 081 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 082 */     scan_scanTime1 = 0;
/* 083 */     scan_batch = null;
/* 084 */     scan_batchIdx = 0;
/* 085 */     scan_colInstance0 = null;
/* 086 */     scan_colInstance1 = null;
/* 087 */     scan_colInstance2 = null;
/* 088 */     scan_colInstance3 = null;
/* 089 */     scan_colInstance4 = null;
/* 090 */     scan_colInstance5 = null;
/* 091 */     scan_colInstance6 = null;
/* 092 */     scan_colInstance7 = null;
/* 093 */     scan_colInstance8 = null;
/* 094 */     scan_colInstance9 = null;
/* 095 */     scan_colInstance10 = null;
/* 096 */     scan_colInstance11 = null;
/* 097 */     scan_colInstance12 = null;
/* 098 */     scan_colInstance13 = null;
/* 099 */     scan_colInstance14 = null;
/* 100 */     scan_colInstance15 = null;
/* 101 */     scan_colInstance16 = null;
/* 102 */     scan_colInstance17 = null;
/* 103 */     scan_colInstance18 = null;
/* 104 */     scan_colInstance19 = null;
/* 105 */     scan_colInstance20 = null;
/* 106 */     scan_colInstance21 = null;
/* 107 */     scan_colInstance22 = null;
/* 108 */     scan_colInstance23 = null;
/* 109 */     scan_colInstance24 = null;
/* 110 */     scan_colInstance25 = null;
/* 111 */     scan_colInstance26 = null;
/* 112 */     scan_colInstance27 = null;
/* 113 */     scan_result = new UnsafeRow(28);
/* 114 */
/* 115 */   }
/* 116 */
/* 117 */   private void scan_nextBatch() throws java.io.IOException {
/* 118 */     long getBatchStart = System.nanoTime();
/* 119 */     if (scan_input.hasNext()) {
/* 120 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 121 */       scan_numOutputRows.add(scan_batch.numRows());
/* 122 */       scan_batchIdx = 0;
/* 123 */       scan_colInstance0 = scan_batch.column(0);
/* 124 */       scan_colInstance1 = scan_batch.column(1);
/* 125 */       scan_colInstance2 = scan_batch.column(2);
/* 126 */       scan_colInstance3 = scan_batch.column(3);
/* 127 */       scan_colInstance4 = scan_batch.column(4);
/* 128 */       scan_colInstance5 = scan_batch.column(5);
/* 129 */       scan_colInstance6 = scan_batch.column(6);
/* 130 */       scan_colInstance7 = scan_batch.column(7);
/* 131 */       scan_colInstance8 = scan_batch.column(8);
/* 132 */       scan_colInstance9 = scan_batch.column(9);
/* 133 */       scan_colInstance10 = scan_batch.column(10);
/* 134 */       scan_colInstance11 = scan_batch.column(11);
/* 135 */       scan_colInstance12 = scan_batch.column(12);
/* 136 */       scan_colInstance13 = scan_batch.column(13);
/* 137 */       scan_colInstance14 = scan_batch.column(14);
/* 138 */       scan_colInstance15 = scan_batch.column(15);
/* 139 */       scan_colInstance16 = scan_batch.column(16);
/* 140 */       scan_colInstance17 = scan_batch.column(17);
/* 141 */       scan_colInstance18 = scan_batch.column(18);
/* 142 */       scan_colInstance19 = scan_batch.column(19);
/* 143 */       scan_colInstance20 = scan_batch.column(20);
/* 144 */       scan_colInstance21 = scan_batch.column(21);
/* 145 */       scan_colInstance22 = scan_batch.column(22);
/* 146 */       scan_colInstance23 = scan_batch.column(23);
/* 147 */       scan_colInstance24 = scan_batch.column(24);
/* 148 */       scan_colInstance25 = scan_batch.column(25);
/* 149 */       scan_colInstance26 = scan_batch.column(26);
/* 150 */       scan_colInstance27 = scan_batch.column(27);
/* 151 */
/* 152 */     }
/* 153 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 154 */   }
/* 155 */
/* 156 */   private void wholestagecodegen_init_2() {
/* 157 */     bhj_result = new UnsafeRow(1);
/* 158 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 159 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 1);
/* 160 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 161 */     bhj_result1 = new UnsafeRow(28);
/* 162 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 384);
/* 163 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 28);
/* 164 */     project_result1 = new UnsafeRow(1);
/* 165 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 166 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 167 */
/* 168 */   }
/* 169 */
/* 170 */   private void wholestagecodegen_init_1() {
/* 171 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 384);
/* 172 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 28);
/* 173 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 174 */     filter_result = new UnsafeRow(28);
/* 175 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 384);
/* 176 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 28);
/* 177 */     project_result = new UnsafeRow(28);
/* 178 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 384);
/* 179 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 28);
/* 180 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 181 */
/* 182 */     bhj_relation = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 183 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 184 */
/* 185 */   }
/* 186 */
/* 187 */   protected void processNext() throws java.io.IOException {
/* 188 */     if (scan_batch == null) {
/* 189 */       scan_nextBatch();
/* 190 */     }
/* 191 */     while (scan_batch != null) {
/* 192 */       int scan_numRows = scan_batch.numRows();
/* 193 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 194 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 195 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 196 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 197 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 198 */
/* 199 */         if (!(!(scan_isNull))) continue;
/* 200 */
/* 201 */         filter_numOutputRows.add(1);
/* 202 */
/* 203 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 204 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 205 */
/* 206 */         // generate join key for stream side
/* 207 */
/* 208 */         bhj_holder.reset();
/* 209 */
/* 210 */         bhj_rowWriter.zeroOutNullBytes();
/* 211 */
/* 212 */         if (scan_isNull2) {
/* 213 */           bhj_rowWriter.setNullAt(0);
/* 214 */         } else {
/* 215 */           bhj_rowWriter.write(0, scan_value2);
/* 216 */         }
/* 217 */         bhj_result.setTotalSize(bhj_holder.totalSize());
/* 218 */
/* 219 */         // find matches from HashedRelation
/* 220 */         UnsafeRow bhj_matched = bhj_result.anyNull() ? null: (UnsafeRow)bhj_relation.getValue(bhj_result);
/* 221 */         if (bhj_matched == null) continue;
/* 222 */
/* 223 */         bhj_numOutputRows.add(1);
/* 224 */
/* 225 */         project_rowWriter1.write(0, scan_value);
/* 226 */         append(project_result1);
/* 227 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 228 */       }
/* 229 */       scan_batchIdx = scan_numRows;
/* 230 */       scan_batch = null;
/* 231 */       scan_nextBatch();
/* 232 */     }
/* 233 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 234 */     scan_scanTime1 = 0;
/* 235 */   }
/* 236 */ }
